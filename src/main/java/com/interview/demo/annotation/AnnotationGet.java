package com.interview.demo.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface AnnotationGet {

    /**
     * Retention 保留(保留策略-运行)
     * 保留策略 存活策略
     * Target 目标
     * 修饰的对象范围
     * Documented 记录，记载(详情);用文件证明(或证实)
     * 用于描述其它类型的annotation 应该被作为被标注的程序成员的公共API，因此可以被例如javadoc 此类的工具文档化。
     * 指示默认情况下，javadoc和类似工具将记录具有类型的注释。这个型别应该用来注解型别的宣告，这些型别的注解会影响使用者使用带注解的项目。
     * 如果一个类型声明被文档化了注释，那么它的注释就成为带注释元素的公共API的一部分。
     * Inherited 继承关系
     * 指示自动继承批注类型。如果注释类型声明中存在继承的元注释，并且用户在类声明中查询注释类型，并且类声明没有此类型的注释，则将自动查询类的超类以获取注释类型。此过程将重复，直到找到此类型的注释，或到达类层次结构（对象）的顶部。如果没有超类具有此类型的注释，则查询将指示相关类没有此类注释。
     * <p>请注意，如果注释类型用于注释类以外的任何内容，则此元注释类型无效。还要注意，这个元注释只会导致注释从超类继承；实现的接口上的注释没有效果。
     */


    /**
     * name
     *
     * @return
     */
    String name();

    /**
     * remarks
     *
     * @return
     */
    String remarks();


    /**
     * 1. document
     * 2. target
     * 3. retention
     * 4. 能不能继承
     */
}
