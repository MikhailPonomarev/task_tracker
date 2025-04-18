package com.proj.tasktracker.model

import jakarta.persistence.*

@Entity
@Table(name = "task_observer")
open class TaskObserver(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    open var task: Task? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    open var user: User? = null
) : BaseEntity() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TaskObserver

        return id == other.id
    }

    override fun hashCode() = 31 * id.hashCode()
}