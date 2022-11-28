
##Error: org.springframework.expression.spel.SpelEvaluationException: EL1008E: Property or field 'name' cannot be found on object of type 'jpanative.Person' - maybe not public or not valid?

##### Similar to https://github.com/spring-projects/spring-framework/issues/29571 ??

How to reproduce:


>> $ mvn native:compile -Pnative

>> $ ./target/demo

>> open localhost:8080

```
.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v3.0.0)

2022-11-27T20:01:08.306-06:00  INFO 15960 --- [           main] jpanative.DemoApplication                : Starting AOT-processed DemoApplication using Java 19.0.1 with PID 15960 (/home/gbuntu/IdeaProjects/spring-native-jpa-getReferenceById-Bug/target/demo started by gbuntu in /home/gbuntu/IdeaProjects/spring-native-jpa-getReferenceById-Bug)
2022-11-27T20:01:08.306-06:00  INFO 15960 --- [           main] jpanative.DemoApplication                : No active profile set, falling back to 1 default profile: "default"
2022-11-27T20:01:08.317-06:00  INFO 15960 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-11-27T20:01:08.318-06:00  INFO 15960 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-27T20:01:08.318-06:00  INFO 15960 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.1]
2022-11-27T20:01:08.323-06:00  INFO 15960 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-27T20:01:08.323-06:00  INFO 15960 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 16 ms
2022-11-27T20:01:08.343-06:00  INFO 15960 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-11-27T20:01:08.344-06:00  INFO 15960 --- [           main] jpanative.DemoApplication                : Started DemoApplication in 0.044 seconds (process running for 0.047)
2022-11-27T20:01:16.705-06:00  INFO 15960 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-11-27T20:01:16.705-06:00  INFO 15960 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-11-27T20:01:16.706-06:00  INFO 15960 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2022-11-27T20:01:16.713-06:00 ERROR 15960 --- [nio-8080-exec-1] org.thymeleaf.TemplateEngine             : [THYMELEAF][http-nio-8080-exec-1] Exception processing template "home": Exception evaluating SpringEL expression: "person.name" (template: "home" - line 6, col 7)

org.thymeleaf.exceptions.TemplateProcessingException: Exception evaluating SpringEL expression: "person.name" (template: "home" - line 6, col 7)
at org.thymeleaf.spring6.expression.SPELVariableExpressionEvaluator.evaluate(SPELVariableExpressionEvaluator.java:292) ~[na:na]
at org.thymeleaf.standard.expression.VariableExpression.executeVariableExpression(VariableExpression.java:166) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.standard.expression.SimpleExpression.executeSimple(SimpleExpression.java:66) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.standard.expression.Expression.execute(Expression.java:109) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.standard.expression.Expression.execute(Expression.java:138) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor.doProcess(AbstractStandardExpressionAttributeTagProcessor.java:144) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.processor.element.AbstractAttributeTagProcessor.doProcess(AbstractAttributeTagProcessor.java:74) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.processor.element.AbstractElementTagProcessor.process(AbstractElementTagProcessor.java:95) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.util.ProcessorConfigurationUtils$ElementTagProcessorWrapper.process(ProcessorConfigurationUtils.java:633) ~[na:na]
at org.thymeleaf.engine.ProcessorTemplateHandler.handleOpenElement(ProcessorTemplateHandler.java:1314) ~[na:na]
at org.thymeleaf.engine.OpenElementTag.beHandled(OpenElementTag.java:205) ~[na:na]
at org.thymeleaf.engine.TemplateModel.process(TemplateModel.java:136) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.engine.TemplateManager.parseAndProcess(TemplateManager.java:661) ~[na:na]
at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1103) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1077) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.spring6.view.ThymeleafView.renderFragment(ThymeleafView.java:372) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.spring6.view.ThymeleafView.render(ThymeleafView.java:192) ~[demo:3.1.0.RELEASE]
at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1414) ~[demo:6.0.2]
at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1158) ~[demo:6.0.2]
at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1097) ~[demo:6.0.2]
at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:973) ~[demo:6.0.2]
at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1003) ~[demo:6.0.2]
at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:895) ~[demo:6.0.2]
at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:705) ~[demo:6.0]
at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:880) ~[demo:6.0.2]
at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:814) ~[demo:6.0]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:223) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[demo:10.1.1]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[demo:6.0.2]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[demo:6.0.2]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[demo:6.0.2]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[demo:6.0.2]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[demo:6.0.2]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[demo:6.0.2]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) ~[na:na]
at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[na:na]
at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542) ~[demo:10.1.1]
at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:119) ~[na:na]
at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[demo:10.1.1]
at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[na:na]
at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357) ~[na:na]
at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:400) ~[na:na]
at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[demo:10.1.1]
at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861) ~[na:na]
at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1739) ~[na:na]
at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[demo:10.1.1]
at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[na:na]
at java.base@19.0.1/java.lang.Thread.run(Thread.java:1589) ~[demo:na]
at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:775) ~[demo:na]
at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:203) ~[na:na]
Caused by: org.springframework.expression.spel.SpelEvaluationException: EL1008E: Property or field 'name' cannot be found on object of type 'jpanative.Person' - maybe not public or not valid?
at org.springframework.expression.spel.ast.PropertyOrFieldReference.readProperty(PropertyOrFieldReference.java:217) ~[na:na]
at org.springframework.expression.spel.ast.PropertyOrFieldReference.getValueInternal(PropertyOrFieldReference.java:104) ~[na:na]
at org.springframework.expression.spel.ast.PropertyOrFieldReference$AccessorLValue.getValue(PropertyOrFieldReference.java:405) ~[na:na]
at org.springframework.expression.spel.ast.CompoundExpression.getValueInternal(CompoundExpression.java:92) ~[na:na]
at org.springframework.expression.spel.ast.SpelNodeImpl.getValue(SpelNodeImpl.java:112) ~[demo:6.0.2]
at org.springframework.expression.spel.standard.SpelExpression.getValue(SpelExpression.java:338) ~[na:na]
at org.thymeleaf.spring6.expression.SPELVariableExpressionEvaluator.evaluate(SPELVariableExpressionEvaluator.java:265) ~[na:na]
... 60 common frames omitted

2022-11-27T20:01:16.715-06:00 ERROR 15960 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.thymeleaf.exceptions.TemplateProcessingException: Exception evaluating SpringEL expression: "person.name" (template: "home" - line 6, col 7)] with root cause

org.springframework.expression.spel.SpelEvaluationException: EL1008E: Property or field 'name' cannot be found on object of type 'jpanative.Person' - maybe not public or not valid?
at org.springframework.expression.spel.ast.PropertyOrFieldReference.readProperty(PropertyOrFieldReference.java:217) ~[na:na]
at org.springframework.expression.spel.ast.PropertyOrFieldReference.getValueInternal(PropertyOrFieldReference.java:104) ~[na:na]
at org.springframework.expression.spel.ast.PropertyOrFieldReference$AccessorLValue.getValue(PropertyOrFieldReference.java:405) ~[na:na]
at org.springframework.expression.spel.ast.CompoundExpression.getValueInternal(CompoundExpression.java:92) ~[na:na]
at org.springframework.expression.spel.ast.SpelNodeImpl.getValue(SpelNodeImpl.java:112) ~[demo:6.0.2]
at org.springframework.expression.spel.standard.SpelExpression.getValue(SpelExpression.java:338) ~[na:na]
at org.thymeleaf.spring6.expression.SPELVariableExpressionEvaluator.evaluate(SPELVariableExpressionEvaluator.java:265) ~[na:na]
at org.thymeleaf.standard.expression.VariableExpression.executeVariableExpression(VariableExpression.java:166) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.standard.expression.SimpleExpression.executeSimple(SimpleExpression.java:66) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.standard.expression.Expression.execute(Expression.java:109) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.standard.expression.Expression.execute(Expression.java:138) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor.doProcess(AbstractStandardExpressionAttributeTagProcessor.java:144) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.processor.element.AbstractAttributeTagProcessor.doProcess(AbstractAttributeTagProcessor.java:74) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.processor.element.AbstractElementTagProcessor.process(AbstractElementTagProcessor.java:95) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.util.ProcessorConfigurationUtils$ElementTagProcessorWrapper.process(ProcessorConfigurationUtils.java:633) ~[na:na]
at org.thymeleaf.engine.ProcessorTemplateHandler.handleOpenElement(ProcessorTemplateHandler.java:1314) ~[na:na]
at org.thymeleaf.engine.OpenElementTag.beHandled(OpenElementTag.java:205) ~[na:na]
at org.thymeleaf.engine.TemplateModel.process(TemplateModel.java:136) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.engine.TemplateManager.parseAndProcess(TemplateManager.java:661) ~[na:na]
at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1103) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1077) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.spring6.view.ThymeleafView.renderFragment(ThymeleafView.java:372) ~[demo:3.1.0.RELEASE]
at org.thymeleaf.spring6.view.ThymeleafView.render(ThymeleafView.java:192) ~[demo:3.1.0.RELEASE]
at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1414) ~[demo:6.0.2]
at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1158) ~[demo:6.0.2]
at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1097) ~[demo:6.0.2]
at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:973) ~[demo:6.0.2]
at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1003) ~[demo:6.0.2]
at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:895) ~[demo:6.0.2]
at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:705) ~[demo:6.0]
at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:880) ~[demo:6.0.2]
at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:814) ~[demo:6.0]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:223) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[demo:10.1.1]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[demo:6.0.2]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[demo:6.0.2]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[demo:6.0.2]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[demo:6.0.2]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[demo:6.0.2]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[demo:6.0.2]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) ~[na:na]
at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[na:na]
at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542) ~[demo:10.1.1]
at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:119) ~[na:na]
at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[demo:10.1.1]
at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[na:na]
at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357) ~[na:na]
at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:400) ~[na:na]
at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[demo:10.1.1]
at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861) ~[na:na]
at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1739) ~[na:na]
at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[demo:10.1.1]
at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[na:na]
at java.base@19.0.1/java.lang.Thread.run(Thread.java:1589) ~[demo:na]
at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:775) ~[demo:na]
at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:203) ~[na:na]
```
