# Mutation Testing (變異測試)
Mutation testing is used to design new software tests and evaluate the quality of existing software tests. Mutation testing involves modifying a program in small ways. Each mutated version is called a mutant and tests detect and reject mutants by causing the behavior of the original version to differ from the mutant. This is called killing the mutant
(https://en.wikipedia.org/wiki/Mutation_testing) 
    
- 用來衡量Test Case品質的一種技巧
- 用來改進測試和程式碼的一種方法
- 當程式發生*變異*時，測試案例應該會發生錯誤，代表*變異*被殺死
- 如*變異*沒被殺死，有可能是測試案例不足或程式碼邏輯有問題


## 常見的變異
- 刪除程式碼
- 重複程式碼，或跳脫程序 (ex:goto , exit, return )
- 布林運算 (true, false , 如把 true 改為 false , 或把 if..else 對調)
- 四則運算 (+ , - , * , /　, 如把 + 變異為 - )
- 遞增、遞減 (++ , -- , 如把 i++ 換成 -ii ，或把　i++ 換成 i++2)
- 比對運算 (> , < , >=, <= , == ，>，如把 > 變異為 < )
- 常數 (如修改常數為不合理值)
- 移除條件 (如拿掉 if .. )
- 返回值 (如把 return 值換成固定值)

## Mutation Testing Tool
透過工具的應用，可加快找到變異點，但工具找到的地方，不一定真的是變異點，並且並非所有變異點能被立即找到。

## 範例：

[原始碼](src/main/java/tw/noah/mutaion/testing/example/service/impl/MathServivceImpl.java)
```java
public long add(int x, int y) {
	long ret = x + y;
	return ret;
}
```
[測試案例](src/test/java/tw/noah/mutaion/testing/example/service/test/MathServiceTest.java)
```java
@Test
public void testAdd(){

	int left = 100;
	int right = 0;
	long add = mathServivce.add(left,right);

	assertEquals(add,left+right);
}
```
程式變異
```java
public long add(int x, int y) {
	long ret = x - y;
	return ret;
}
```
再測試後，測試案例並沒有報錯，經檢查後，調整如下：
```java
@Test
public void testAdd(){

	int left = 100;
	int right = 0;
	long add = mathServivce.add(left,right);

	assertEquals(add,left+right);


	left = 100;
	right = 3;
	add = mathServivce.add(left,right);

	assertEquals(add,left+right);
}
```
這次發生錯誤，代表已找到變異問題
```java
java.lang.AssertionError: 
Expected :97
Actual   :103
	at org.junit.Assert.fail(Assert.java:88)
	at org.junit.Assert.failNotEquals(Assert.java:834)
	at org.junit.Assert.assertEquals(Assert.java:645)
	at org.junit.Assert.assertEquals(Assert.java:631)
	at MathServiceTest.testAdd(MathServiceTest.java:36)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.springframework.test.context.junit4.statements.RunBeforeTestExecutionCallbacks.evaluate(RunBeforeTestExecutionCallbacks.java:73)
	at org.springframework.test.context.junit4.statements.RunAfterTestExecutionCallbacks.evaluate(RunAfterTestExecutionCallbacks.java:83)
	at org.springframework.test.context.junit4.statements.RunBeforeTestMethodCallbacks.evaluate(RunBeforeTestMethodCallbacks.java:75)
	at org.springframework.test.context.junit4.statements.RunAfterTestMethodCallbacks.evaluate(RunAfterTestMethodCallbacks.java:86)
	at org.springframework.test.context.junit4.statements.SpringRepeat.evaluate(SpringRepeat.java:84)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:251)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:97)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:190)
	at org.junit.runners.Suite.runChild(Suite.java:128)
	at org.junit.runners.Suite.runChild(Suite.java:27)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
```