package com.taekwonv.jdbc.service;

import com.taekwonv.jdbc.domain.Member;
import com.taekwonv.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {

    private final DataSource dataSource;
    private final MemberRepositoryV2 memberRepositoryV1;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {

        Connection con = dataSource.getConnection();
        try {
            con.setAutoCommit(false); // 트랜잭션 시작
            // 비즈니스 로직
            bizLogic(con, toId, money, fromId);
            con.commit(); // 성공 시 커밋
        } catch (Exception e) {
            con.rollback(); // 실패 시 롤백
            throw new IllegalStateException(e);
        } finally {
            if (con != null) {
                try {
                    release(con);
                } catch (Exception e) {
                    log.info("error", e);
                }
            }
        }
    }

    private void bizLogic(Connection con, String toId, int money, String fromId) throws SQLException {
        Member fromMember = memberRepositoryV1.findById(con, fromId);
        Member toMember = memberRepositoryV1.findById(con, toId);

        memberRepositoryV1.update(con, fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepositoryV1.update(con, toId, toMember.getMoney() + money);
    }

    private void release(Connection con) throws SQLException {
        con.setAutoCommit(true); // 기본 값 (true) 를 복원한 뒤 커넥션 풀에 반환한다.
        con.close();
    }

    private void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체 중 예외 발생");
        }
    }
}
