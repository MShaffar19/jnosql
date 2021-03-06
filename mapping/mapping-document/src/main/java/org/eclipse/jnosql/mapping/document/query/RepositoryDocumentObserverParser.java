/*
 *  Copyright (c) 2017 Otávio Santana and others
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   and Apache License v2.0 which accompanies this distribution.
 *   The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *   and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 *   You may elect to redistribute this code under either of these licenses.
 *
 *   Contributors:
 *
 *   Otavio Santana
 */
package org.eclipse.jnosql.mapping.document.query;

import jakarta.nosql.document.DocumentObserverParser;
import org.eclipse.jnosql.mapping.reflection.ClassMapping;

import java.util.Optional;

public class RepositoryDocumentObserverParser implements DocumentObserverParser {

    private final ClassMapping classMapping;

    RepositoryDocumentObserverParser(ClassMapping classMapping) {
        this.classMapping = classMapping;
    }

    @Override
    public String fireEntity(String entity) {
        return classMapping.getName();
    }

    @Override
    public String fireField(String entity, String field) {
        return Optional.ofNullable(classMapping.getColumnField(field)).orElse(field);
    }
}
