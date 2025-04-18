package com.proj.tasktracker.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.proj.tasktracker.enums.TaskStatus
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "tasks")
open class Task(
    @Column(nullable = false, length = 255)
    open var title: String? = null,

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    open var status: TaskStatus = TaskStatus.TODO,

    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var taskTags: MutableSet<TaskTag> = mutableSetOf(),

    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var taskAssignees: MutableSet<TaskAssignee> = mutableSetOf(),

    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var taskObservers: MutableSet<TaskObserver> = mutableSetOf()
) : BaseEntity(), Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task

        if (id != other.id) return false
        if (title != other.title) return false
        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + status.hashCode()
        return result
    }

    override fun toString(): String {
        return "Task(id=$id, title=$title, status=$status)"
    }
}