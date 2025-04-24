package com.proj.tasktracker.model

import jakarta.persistence.*

@Entity
@Table(name = "team_members")
open class TeamMember(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    open var team: Team? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    open var user: User? = null
) : BaseEntity() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TaskAssignee

        return id == other.id
    }

    override fun hashCode() = 31 * id.hashCode()
}