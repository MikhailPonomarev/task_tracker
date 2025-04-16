package com.proj.tasktracker.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "tags")
open class Tag(
    @Column(nullable = false)
    open var name: String? = null,

    @JsonIgnore
    @OneToMany(mappedBy = "tag", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var taskTags: MutableSet<TaskTag> = mutableSetOf()
) : BaseEntity(), Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Tag

        if (id != other.id) return false

        return name == other.name
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Tag(id=$id, name=$name)"
    }
}