# [DevOps] CI(Continuous Integration) / CD(Deploy)

\# Diff between Build vs Deploy

### | Wiki 

> In software engineering, CI/CD or CICD is the conbined practices of continuous integration and either continuous delivery or continuous deployment. 
>
> CI/CD bridges the gaps between developent and operation activities and teams by enforcing automation in building, testing and deployment of applications. Modern day DepOps practices. invlove continous development, continuous testing, continuous integration, continuous deployment and continuous monitoring of sofware applications throughout its development life cycle. The CI/CD practice, or CI/CD pipeline, forms the backbone of modern day DevOps operations. 

### | Difference Build vs Deploy

위 두 비교 대상은 '대조'적인 의미로 보는 것보단 예를 들어 애플리케이션을 실제 사용 유저로 하여금 접근할 수 있도록 하는 일련의 과정에서 설명하는 것이 이해하기 쉽다. 프로그래밍 언어 별로 컴파일이 필요한 언어와 그렇지 않은 언어가 있어 차이가 있을 수 있다. 이번 글에서는 **Java(need to be complied)**를 기준으로 빌드와 배포를 설명한다. 



### | CI (Continuous Integration)

 \# Automating Test 

단어 뜻을 해석했을 때 쉽게 알 수 있듯이 '지속적' + '통합, 병합'의 의미를 갖는다. 이 뜻을 더 심오하게 확인하는 것 보단, '지속적 + 통합 또는 병합'이라는 개념이 나타날 수 밖에 없는 이유를 생각해보자. 

예를 들어, N명의 개발자 팀원들과 협업을 하는 과정에서 소스 관리를 하기 위해 중앙 리포지토리가 있을 것이고 기준이 되는 중앙 리포지토리에서 `feature`를 생성해서 개발을 이어갈 것이다. 해당 `feature`가 완료되면 중앙 리포지토로 병합 후 테스트를 통해 개발된 내역 중 버그가 없는 지 확인할 것이다.  여기서 이러한 행위가 반복되면서 아래와 같은 문제가 발생할 수 있다.

- ###### 중앙 리포지토리로 누적되는 코드의 양이 많아지고 이는 결국 테스트 항목의 수 역시 비례해서 늘어난다. 

위 문제를 해결하려면 어떤 방법이 필요할까? 먼저, 위 문제를 재정리하면 병합 장소인 중앙 리포지토리 내 코드에 대한 테스트가 매우 반복적이고 실수를 야기하기 쉬운 구조라는 것이다. 결국 테스트 자동화를 통해 중앙 리포지토리의 코드의 안전성을 높일 수 있고, 테스트를 통과한 이후에만 병합하도록 전제를 두면, 중앙 리포지토리 자체를 항상 배포 가능한 상태로 유지할 수 있을 것이다. 

이러한 역할을 수행하는 개념을 `Continuous Integration` 즉, 지속적인 통합이라고 한다. 

### | CD (Continuous Deploy)

### | Reference

###### https://itholic.github.io/qa-compile-build-deploy/

###### https://www.quora.com/What-is-the-difference-between-deploy-and-build-in-software-development