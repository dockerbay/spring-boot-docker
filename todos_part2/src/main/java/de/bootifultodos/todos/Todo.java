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

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static lombok.AccessLevel.PROTECTED;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Eine beliebige, zu erledigendes Aufgabe. Beinhaltet in diesem Kontext noch
 * kein Datum, an dem etwas erledigt werden soll oder nicht.
 *
 */
@SuppressWarnings({"checkstyle:designforextension"})
@Entity
@Table(name = "todos")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Todo implements Serializable {

	private static final long serialVersionUID = -7853758555474031284L;

	public enum  Status {
		OFFEN, ERLEDIGT
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** Externe Id des Besitzers. */
	@CreatedBy
	@ReadOnlyProperty
	private String userId;

	/** Die zu erledigende Aufgabe. */
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Setter
	private String aufgabe;

	/** Datum der letzten Änderung. */
	@LastModifiedDate
	@ReadOnlyProperty
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;

	/** Status des Todos. */
	@Setter
	@Enumerated(EnumType.STRING)
	private Status status = Status.OFFEN;

	public Todo(final String aufgabe) {
		this.aufgabe = aufgabe;
	}
}
