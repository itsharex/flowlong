/* Copyright 2023-2025 jobob@qq.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.mysql.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.mysql.MysqlTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanco
 * @since 1.0
 */
public class TestReject extends MysqlTest {
	@BeforeEach
	public void before() {
		processId = this.deployByResource("test/task/reject.long");
		flowLongEngine.startInstanceById(processId,"creator");
	}
	
	@Test
	public void test() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("number", 2);
//		flowLongEngine.executeTask(1632628269813387266L, "creator", args);
//		flowLongEngine.executeAndJumpTask(1632628549665792002L, "creator", args, "task1");
	}
}
