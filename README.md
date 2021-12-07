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
    implementation 'com.github.3jq:hookdispatcher:1.2'
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
    <version>1.2</version>
</dependency>
```

<div align="center">

## Usage
</div>

```java
public class Main {
	public static void main(String[] args) {
		EventDispatcher eventDispatcher = new EventDispatcher();
		eventDispatcher.register(new TestHandler());
		eventDispatcher.post(new TestEvent());
	}

public class TestHandler {
	@Subscribe
	public void onEvent(TestEvent event) {
		System.out.println("Hey, I am working!");
	}
}

public class TestEvent {}
```

## Performance

Since when I was testing, it was doing 1 mil tasks for 7586 millis (the fastest, avg 8966)
