package data.local.transaction

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionLocalModel (
  @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int = 0,
  @ColumnInfo(name = "price") val price: String,
)