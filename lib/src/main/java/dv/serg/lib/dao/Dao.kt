package dv.serg.lib.dao

import java.io.Serializable

interface Dao<K : Comparable<K>, V : Comparable<V>> {
    fun create(value: V): V
    fun read(key: K): V
    fun update(value: V)
    fun delete(value: V)
}