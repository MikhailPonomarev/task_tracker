package com.proj.tasktracker.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "teams")
open class Team(
    @Column(nullable = false, length = 255)
    open var name: String? = null,

    @JsonIgnore
    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var teamMembers: MutableSet<TeamMember> = mutableSetOf()
) : BaseEntity(), Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Team) return false

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
        return "Team(id=$id, name=$name)"
    }
}