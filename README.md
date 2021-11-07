<div align="center">

# HookDispatcher - Tiny and fast event dispatcher.

## Installation

Gradle
</div>

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.3jq:hookdispatcher:1.0'
}
```
<div align="center">

Maven
</div>

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
    
<dependency>
    <groupId>com.github.3jq</groupId>
	  <artifactId>hookdispatcher</artifactId>
    <version>1.0</version>
</dependency>
```

<div align="center">

## Usage
</div>

```java
@Subscribe
public void onEvent(Event event) {
	System.out.println("Hey, I am working!");
}
```
