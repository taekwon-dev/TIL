# @NoArgsConstructor

> @NoArgsConstructor will generate a constructor with no parameters. If this is not possible (because of final fields), a compiler error will result instead. 
>
> 파라미터가 없는 기본 생성자를 생성하는 역할, 단 필드 중 `final` 키워드가 붙은 경우에는 컴파일 단계에서 에러가 발생
>
> Unless <u>@NoArgsConstructor(force = true)</u> is used, then all final fileds are initialized with `0 / false / null`.
>
> `force = true` 속성을 지정하지 않은 이상, final 키워드가 붙은 필드는 `0 / false / null` 중 하나로 초기화

> For filed with constraints, such as @NonNull filed, *no* check is generated, so be aware that these constraints will generally not be fullfilled until those fields are properly initialized later. 
>
> 





### | Reference

###### https://projectlombok.org/features/constructor