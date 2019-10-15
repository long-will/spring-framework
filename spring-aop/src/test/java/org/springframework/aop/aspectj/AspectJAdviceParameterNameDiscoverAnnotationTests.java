/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;

/**
 * Additional parameter name discover tests that need Java 5.
 * Yes this will re-run the tests from the superclass, but that
 * doesn't matter in the grand scheme of things...
 *
 * @author Adrian Colyer
 * @author Chris Beams
 */
public class AspectJAdviceParameterNameDiscoverAnnotationTests extends AspectJAdviceParameterNameDiscovererTests {

	/**
	 * 附加名称发现
	 * Class 是Object子类，类型；一般用于反射，可以通过其他类型的元数据，比如字段，属性，构造器，方法等；不能通过new实例化；
	 * Object 对象
	 * class 关键字
	 */
	@Test
	public void testAnnotationBinding() {
		assertParameterNames(getMethod("pjpAndAnAnnotation"),
				"execution(* *(..)) && @annotation(ann)",
				new String[] {"thisJoinPoint","ann"});
	}


	public void pjpAndAnAnnotation(ProceedingJoinPoint pjp, MyAnnotation ann) {}

	@interface MyAnnotation {}

}
