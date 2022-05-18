# Component Scanning 

> We can annotate our classes in order to make them into Spring beans, we can tell Spring where to search for these annotated classes, as not all of them must becomes beans in this particular run.
>
> 컴포넌트 스캔이란 개념은 우리가 빈으로 등록하길 원하는 요소를 스캔하여 빈으로 등록시켜 주는 역할을 한다. 

### | @ComponentScan without Arguments

> @ComponentScan annotation along with the @Configuration annotation to specify the packages that we want to be scanned. @ComponentScan without arguments tells <u>Spring to scan the current package</u> and all of its <u>sub-packages</u>.
>
> @Configuration, @ComponentScan이 동시에 선언되어 있는 경우 해당 클래스가 속한 패키지 또한 서브 패키지 모두가 빈 등록을 위한 스캔 대상이 된다. 

```java
"com.baeldung.componentscan.springapp"
@Configuration
@ComponentScan
public class SpringComponentScanApp {
    private static ApplicationContext applicationContext;

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    public static void main(String[] args) {
        applicationContext = 
          new AnnotationConfigApplicationContext(SpringComponentScanApp.class);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
```

> Note that the main application class (=SpringComponentScanApp) is also a bean, as it's annotated with <u>@Configuration, which is a @Component.</u>  We should also note that the main application class and the configuration class are not necessarily the same. If they are different, it doesn't matter where we put the main application class. Only the location of the configuration class matters, as component scanning starts from its package by default. 
>
> Component Scan은 해당 어노테이션이 붙은 클래스의 패키지를 기준으로 스캔 한다. 

```java
@ComponentScan(basePackages = "com.baeldung.componentscan.springapp")
```



### | @ComponentScan with Arguments

### | The Default Package

> We should avoid putting the *@Configuration* class [in the default package](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-structuring-your-code.html) (i.e. by not specifying the package at all). If we do, Spring scans all the classes in all jars in a classpath, which causes errors and the application probably doesn't start.



### | Reference

###### https://www.baeldung.com/spring-component-scanning

###### https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code

###### https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html