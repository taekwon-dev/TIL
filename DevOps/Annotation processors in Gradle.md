# Annotation processors in Gradle

\# java \# compile \# javac 

> Annotation processing is a Java compilation option which has been around since Java 5. It enables the **generation of additional files during compilation**, such as classes or documentation.



### | Annotation processing in Gradle

> Fortunately the clever people at Gradle HQ have provided us with a very easy way to specify the above `-processorpath` compiler option. We do this by marking a particular dependency as part of the `annotationProcessor` dependency configuration.
>
> **What does this do?** Well much like the other dependency configurations (*implementation*, *compileOnly* etc.), all we’re really doing is defining what will get passed to the Java compiler when the `compileJava` Gradle task get executed. In the case of `annotationProcessor` we’re defining what libraries get passed to the `-processorpath` `javac` option.



![image-20211219145945808](/Users/youn/Library/Application Support/typora-user-images/image-20211219145945808.png)

> This clearly shows that the dependency which was specified with `annotationProcessor` has ended up on the `-processorpath` of the Java compiler. 

### | Reference

###### https://tomgregory.com/annotation-processors-in-gradle-with-the-annotationprocessor-dependency-configuration/