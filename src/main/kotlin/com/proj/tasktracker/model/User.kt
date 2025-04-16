package com.proj.tasktracker.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "users")
open class User(
    @Column(nullable = false)
    open var name: String? = null,

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var teamMembers: MutableSet<TeamMember> = mutableSetOf(),

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var taskAssignees: MutableSet<TaskAssignee> = mutableSetOf(),

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var taskObservers: MutableSet<TaskObserver> = mutableSetOf()
) : BaseEntity(), Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "User(id=$id, name=$name, teamMembers=$teamMembers)"
    }
}