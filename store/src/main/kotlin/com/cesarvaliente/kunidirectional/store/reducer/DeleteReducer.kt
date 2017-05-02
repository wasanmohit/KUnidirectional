/**
 * Copyright (C) 2017 Cesar Valiente & Corey Shaw
 *
 * https://github.com/CesarValiente
 * https://github.com/coshaw
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

package com.cesarvaliente.kunidirectional.store.reducer

import com.cesarvaliente.kunidirectional.store.Item
import com.cesarvaliente.kunidirectional.store.action.DeleteAction
import com.cesarvaliente.kunidirectional.store.action.DeleteAction.DeleteItemAction


object DeleteReducer : Reducer<DeleteAction>() {

    override fun reduceItemsCollection(action: DeleteAction, currentItems: List<Item>): List<Item> =
            when (action) {
                is DeleteItemAction -> currentItems.filterNot { it.localId == action.localId }
            }

    override fun reduceCurrentItem(action: DeleteAction, currentItem: Item): Item =
            when (action) {
                is DeleteItemAction -> if (action.localId == currentItem.localId) Item() else currentItem
            }

}