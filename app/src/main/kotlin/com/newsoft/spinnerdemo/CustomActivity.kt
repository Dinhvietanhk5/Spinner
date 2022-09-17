/*
 * Designed and developed by 2019 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.newsoft.spinnerdemo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.newsoft.spinner.IconSpinnerAdapter
import com.newsoft.spinner.IconSpinnerItem
import com.newsoft.spinnerdemo.databinding.ActivityCustomBinding

class CustomActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = ActivityCustomBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.spinnerView.apply {
      setSpinnerAdapter(IconSpinnerAdapter(this))
      setItems(
        arrayListOf(
          IconSpinnerItem(iconRes = R.drawable.unitedstates, text = "USA", tag = Data(0,"USA Data")),
          IconSpinnerItem(iconRes = R.drawable.unitedkingdom, text = "UK", tag = Data(0,"UK Data")),
          IconSpinnerItem(iconRes = R.drawable.france, text = "France", tag = Data(0,"France Data")),
          IconSpinnerItem(icon = contextDrawable(R.drawable.canada), text = "Canada", tag = Data(0,"Canada Data")),
          IconSpinnerItem(icon = contextDrawable(R.drawable.southkorea), text = "South Korea", tag = Data(0,"South Korea Data")),
          IconSpinnerItem(icon = contextDrawable(R.drawable.germany), text = "Germany", tag = Data(0,"Germany Data")),
          IconSpinnerItem(icon = contextDrawable(R.drawable.spain), text = "Spain", tag = Data(0,"Spain Data")),
          IconSpinnerItem(icon = contextDrawable(R.drawable.china), text = "China", tag = Data(0,"China Data"))
        )
      )
      setOnSpinnerItemSelectedListener<IconSpinnerItem> { _, _, _, item ->
        val data = item.tag as Data
        data.title
        Toast.makeText(applicationContext, data.title, Toast.LENGTH_SHORT).show()
      }
      getSpinnerRecyclerView().layoutManager = GridLayoutManager(baseContext, 2)
      selectItemByIndex(4)
      preferenceName = "country"
    }

    binding.spinnerView1.apply {
      setOnSpinnerItemSelectedListener<String> { _, _, _, item ->
        binding.spinnerView2.hint = item
        Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
      }
      preferenceName = "question1"
    }

    binding.spinnerView2.preferenceName = "question2"

    binding.spinnerView3.preferenceName = "year"

    binding.spinnerView4.preferenceName = "month"

    binding.spinnerView5.preferenceName = "day"
  }

  private fun contextDrawable(@DrawableRes resource: Int): Drawable? {
    return ContextCompat.getDrawable(this@CustomActivity, resource)
  }
}
