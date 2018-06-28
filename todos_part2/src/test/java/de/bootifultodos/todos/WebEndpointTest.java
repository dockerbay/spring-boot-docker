/*
 * Copyright 2017 michael-simons.eu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.bootifultodos.todos;

import de.bootifultodos.todos.Todo.Status;
import java.util.Locale;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.fail;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import org.mockito.ArgumentCaptor;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/**
 * TODO Erweitere die Tests indem Du MockMvc für Restabfragen verwendest
 */
@RunWith(SpringRunner.class)
@WebMvcTest(
	includeFilters
	= @Filter(type = ASSIGNABLE_TYPE, classes = TodoValidator.class)
)
public class WebEndpointTest {

	/**
	 * Makes the tests locale aware.
	 */
	@TestConfiguration
	static class Config {
		
		@Bean
		public LocaleResolver localeResolver() {
			return new FixedLocaleResolver(Locale.GERMANY);
		}
	}
	
	@MockBean
	private TodoRepository todoRepository;
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void emptyFormShouldWork() throws Exception {
		this.mvc
			.perform(get("/todos/new").with(user("test")))
			.andExpect(status().isOk())
			.andExpect(view().name("form"))
			.andExpect(model().attributeDoesNotExist("id"))
			.andExpect(model().attributeExists("todo"))
			.andExpect(model().attribute("method", "POST"))
			.andExpect(model().attribute("statii", Todo.Status.values()));
	}

	@Test
	public void filledFormShouldWork() throws Exception {
		fail("FIXME");

//		final Todo todo = new Todo();
//		ReflectionTestUtils.setField(todo, "id", 23L);
//		todo.setAufgabe("test");
//		todo.setStatus(Todo.Status.OFFEN);
//		when(todoRepository.findOne(23L)).thenReturn(Optional.of(todo));
//
//		// TODO Überprüfe ob eine gestetzte Aufgabe via get abgefragt werden kann.
//		// Stelle dabei sicher, dass die Attribute id und todo richtig gesetzt wurden.

	}

	@Test
	public void createShouldWorkWithValidData() throws Exception {
		fail("FIXME");

//		final Todo todo = new Todo();
//		ReflectionTestUtils.setField(todo, "id", 23L);
//		when(todoRepository.save(any(Todo.class))).thenReturn(todo);
//
//		// TODO Überprüfe ob ein Todo für einen user gesetzt werden kann

	}

	@Test
	public void createShouldWorkWithInvalidData() throws Exception {
		fail("FIXME");

//		final Todo todo = new Todo();
//		ReflectionTestUtils.setField(todo, "id", 23L);
//		when(todoRepository.save(any(Todo.class))).thenReturn(todo);
//
//		// TODO Überprüfe ob ein Todo mit validen Daten gesetzt werden kann
	}

	@Test
	public void updateShouldWorkWithInvalidTodo() throws Exception {
		fail("FIXME");

//		when(todoRepository.findOne(23L)).thenReturn(Optional.empty());
//
//		// TODO Überprüfe ob ein Todo mit invaliden Daten nicht gesetzt werden kann
	}

	@Test
	public void updateShouldWorkWithValidData() throws Exception {
		fail("FIXME");

//		final Todo todo = new Todo();
//		ReflectionTestUtils.setField(todo, "id", 23L);
//		when(todoRepository.findOne(23L)).thenReturn(Optional.of(todo));
//		when(todoRepository.save(any(Todo.class))).then(returnsFirstArg());
//
//		// TODO Überprüfe ob ein Todo mit validen Daten auch upgedatet werden kann
	}

	@Test
	public void updateShouldWorkWithInvalidData() throws Exception {
		fail("FIXME");

//		final Todo todo = new Todo();
//		ReflectionTestUtils.setField(todo, "id", 23L);
//		when(todoRepository.findOne(23L)).thenReturn(Optional.of(todo));
//
//		// TODO Überprüfe ob ein Todo mit invaliden Daten beim updaten abgelehnt wird
//
	}
}
