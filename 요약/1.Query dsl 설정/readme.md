QueryDsl 설정
============

### 1. 빌드툴 설정(gradle)
```
plugins {
    id "com.ewerk.gradle.plugins.querydsl" version "1.0.10"
}

dependencies {
    implementation 'com.querydsl:querydsl-jpa'
}

// querydsl Q타입 설정
def querydslDir = "$buildDir/generated/querydsl"
querydsl {
    jpa = true
    querydslSourcesDir = querydslDir
}
sourceSets {
    main.java.srcDir querydslDir
}
configurations {
    querydsl.extendsFrom compileClasspath
}
compileQuerydsl {
    options.annotationProcessorPath = configurations.querydsl
}
```
> Q파일 경로를 build 아래에 두어서 .gitignore 할 필요가 없다.
> 즉, Q파일은 git에 올리면 안된다.

### 2. Q파일 컴파일
아래의 방법 중 하나로 컴파일 할 수있다.
* intellij: gradle -> tasks/other/compileQuerydls
* Terminal: ./gradlew compileQuerydsl
> 프로젝트/build/generated 아래에 Q파일이 잘 생성 되는지 확인 할 것.