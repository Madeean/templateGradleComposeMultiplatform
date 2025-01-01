package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import data.local.transaction.TransactionDao
import data.local.transaction.TransactionLocalModel

@Database(
  entities = [TransactionLocalModel::class],
  version = 1
)
abstract class AppDatabase: RoomDatabase() {
  abstract val transactionDao: TransactionDao

  companion object {
    const val DB_NAME = "MadeeMoneyTrackDB"
  }
}