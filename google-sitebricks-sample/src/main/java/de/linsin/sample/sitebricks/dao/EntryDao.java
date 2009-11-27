/*
 * Copyright 2009 David Linsin
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

package de.linsin.sample.sitebricks.dao;

import de.linsin.sample.sitebricks.domain.Entry;

import java.util.List;

/**
 * Interface used to talk to persistent storage
 *
 * @author David Linsin - linsin@synyx.de
 */
public interface EntryDao {

    Integer save(Entry entry);

    Entry read(Integer id);

    List<Entry> readAll();

    void delete(Entry entry);
}
