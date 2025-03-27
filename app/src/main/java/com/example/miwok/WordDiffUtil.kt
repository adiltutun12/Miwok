package com.example.miwok


import androidx.recyclerview.widget.DiffUtil
import com.example.miwok.model.Word

class WordDiffUtil(
    private val oldList: List<Word>,
    private val newList: List<Word>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].defaultTranslation == newList[newItemPosition].defaultTranslation
        //ako vrati true diffUtil zna da je to ista stavka i provjerava samo podatke
        //Ako vraća false, smatra da je to potpuno nova stavka.
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
        //Ako vraća true, RecyclerView neće ažurirati tu stavku, jer je ista.
        //Ako vraća false, RecyclerView će osvježiti tu stavku jer se njen sadržaj promijenio.
    }
}

/* DiffUtil automatski izračunava razlike između stare i nove liste i obavještava RecyclerView
samo o onim stavkama koje su se zaista promijenile, umjesto da ponovo crta sve.

-Određuje koje stavke treba ažurirati, dodati ili ukloniti.
-Efikasno ažurira samo promijenjene stavke u RecyclerView


*/