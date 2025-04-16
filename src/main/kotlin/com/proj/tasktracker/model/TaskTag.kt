package com.proj.tasktracker.model

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "task_tags")
open class TaskTag(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    open var task: Task? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    open var tag: Tag? = null
) : BaseEntity() {

    override fun toString(): String {
        return "TaskTag(id=$id, task=$task, tag=$tag)"
    }
}