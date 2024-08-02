package com.ctw.workstation.booking.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.shared.entity.AbstractTimeEntity;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_BOOKING")
public class Booking extends AbstractTimeEntity {

    @Column(name = "RACK_ID", nullable = false)
    private UUID rackId;

    @Column(name = "REQUESTER_ID", nullable = false)
    private UUID requesterId;

    @Column(name = "BOOK_FROM", length = 50, nullable = false)
    private String bookFrom;

    @Column(name = "BOOK_TO", length = 50, nullable = false)
    private String bookTo;

    @ManyToOne
    @JoinColumn(name = "rack_id", insertable = false, updatable = false)
    private Rack rack;

    @ManyToOne
    @JoinColumn(name = "requester_id", insertable = false, updatable = false)
    private TeamMember teamMember;

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public String getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(String bookFrom) {
        this.bookFrom = bookFrom;
    }

    public String getBookTo() {
        return bookTo;
    }

    public void setBookTo(String bookTo) {
        this.bookTo = bookTo;
    }
}