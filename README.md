# enjoy-spring-boot-starter

#### 介绍
enjoy模板引擎starter

#### 框架版本
1. 1.x依赖于springboot 1.5.x版本，JDK1.7+
2. 2.0.x依赖于springboot 2.0.x版本，JDK1.8+

#### 起步
```xml
<dependency>
    <groupId>com.xbdframework.boot</groupId>
    <artifactId>enjoy-spring-boot-starter</artifactId>
    <version>版本号</version>
</dependency>
```

#### 属性配置
EnjoyProperties
<table>
    <tr>
        <td>配置项</td>
        <td>说明</td>
        <td>默认值</td>
    </tr>
    <tr>
        <td>devMode</td>
        <td>开发模式</td>
        <td>false</td>
    </tr>
    <tr>
        <td>prefix</td>
        <td>模板前缀</td>
        <td>无</td>
    </tr>
    <tr>
        <td>suffix</td>
        <td>模板后缀</td>
        <td>.html</td>
    </tr>
    <tr>
        <td>contentType</td>
        <td>contentType</td>
        <td>text/html</td>
    </tr>
    <tr>
        <td>templatePath</td>
        <td>模板路径</td>
        <td>classpath:/templates/</td>
    </tr>
    <tr>
        <td>checkTemplateLocation</td>
        <td>模板路径检查</td>
        <td>true</td>
    </tr>
    <tr>
        <td>exposeRequestAttributes</td>
        <td></td>
        <td>false</td>
    </tr>
    <tr>
        <td>allowRequestOverride</td>
        <td></td>
        <td>false</td>
    </tr>
    <tr>
        <td>exposeSessionAttributes</td>
        <td></td>
        <td>false</td>
    </tr>
    <tr>
        <td>allowSessionOverride</td>
        <td></td>
        <td>false</td>
    </tr>
    <tr>
        <td>exposeSpringMacroHelpers</td>
        <td></td>
        <td>false</td>
    </tr>
    <tr>
        <td>sessionInView</td>
        <td></td>
        <td>false</td>
    </tr>
    <tr>
        <td>createSession</td>
        <td></td>
        <td>false</td>
    </tr>
</table>

#### 个性化配置

实现JFinalViewResolverCustomizer接口并注册为spring bean即可

#### 异常页面
EnjoyTemplateAvailabilityProvider提供默认异常页面的扫描逻辑


