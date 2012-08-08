/*
Copyright 2012 Yusuke Yamamoto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
Distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package fizzbuzz;

public class MainTest extends junit.framework.TestCase {
    public void testFizzBuzz() throws Exception {
        assertEquals("Fizz", Main.fizzBuzz("@fizzbuzz 3"));
        assertEquals("Fizz", Main.fizzBuzz("@fizzbuzz 3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333"));
        assertEquals("Buzz", Main.fizzBuzz("@fizzbuzz 5"));
        assertEquals("Fizz Buzz", Main.fizzBuzz("@fizzbuzz 15"));
        assertEquals("", Main.fizzBuzz("@fizzbuzz 16"));
    }
}
