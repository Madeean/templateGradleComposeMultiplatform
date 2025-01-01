package sharedFunction

import androidx.room.Room
import androidx.room.RoomDatabase.Builder
import data.local.AppDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual class DatabaseFactory {
  actual fun create(): Builder<AppDatabase> {
    val dbFile = documentDirectory() + "/${AppDatabase.DB_NAME}"
    return Room.databaseBuilder<AppDatabase>(dbFile)
  }

  @OptIn(ExperimentalForeignApi::class)
  private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
      directory = NSDocumentDirectory,
      inDomain = NSUserDomainMask,
      appropriateForURL = null,
      create = false,
      error = null
    )
    return requireNotNull(documentDirectory?.path)
  }
}