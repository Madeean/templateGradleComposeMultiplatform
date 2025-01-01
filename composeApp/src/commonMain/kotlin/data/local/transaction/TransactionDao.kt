package data.local.transaction

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TransactionDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addTransaction(model: TransactionLocalModel)

  @Query("SELECT * FROM transactions")
  fun getAllTransactions(): List<TransactionLocalModel>
}