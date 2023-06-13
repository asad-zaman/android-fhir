/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.google.android.fhir.demo.databinding.FamilyListItemViewBinding
import com.google.android.fhir.demo.databinding.PatientListItemViewBinding

/** UI Controller helper class to monitor Patient viewmodel and display list of patients. */
class FamilyItemRecyclerViewAdapter(
  private val onItemClicked: (FamilyListViewModel.FamilyItem) -> Unit
) :
  ListAdapter<FamilyListViewModel.FamilyItem, FamilyItemViewHolder>(FamilyItemDiffCallback()) {

  class FamilyItemDiffCallback : DiffUtil.ItemCallback<FamilyListViewModel.FamilyItem>() {
    override fun areItemsTheSame(
      oldItem: FamilyListViewModel.FamilyItem,
      newItem: FamilyListViewModel.FamilyItem
    ): Boolean = oldItem.resourceId == newItem.resourceId

    override fun areContentsTheSame(
      oldItem: FamilyListViewModel.FamilyItem,
      newItem: FamilyListViewModel.FamilyItem
    ): Boolean = oldItem.id == newItem.id && oldItem.risk == newItem.risk
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyItemViewHolder {
    return FamilyItemViewHolder(
      FamilyListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }

  override fun onBindViewHolder(holder: FamilyItemViewHolder, position: Int) {
    val item = currentList[position]
    holder.bindTo(item, onItemClicked)
  }
}
