package com.ctw.workstation.booking.entity;

import java.time.LocalDateTime;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.shared.event.EventListener;
import com.ctw.workstation.teammember.entity.TeamMember;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_BOOKING")
@EntityListeners(EventListener.class)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGenerator")
    @SequenceGenerator(name = "bookingIdGenerator", sequenceName = "SEQ_BOOKING_ID")
    private Long id;

    @Column(name = "RACK_ID")
    private Long rackId;

    @Column(name = "REQUESTER_ID")
    private Long requesterId;

    @Column(name = "BOOK_FROM")
    private LocalDateTime bookFrom;

    @Column(name = "BOOK_TO")
    private LocalDateTime bookTo;

    @Column(name = "MODIFIED_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name = "CREATED_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID", updatable = false, insertable = false, nullable = false)
    public Rack rack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUESTER_ID", updatable = false, insertable = false, nullable = false)
    public TeamMember teamMember;

    public Booking() {
    }

    public Booking(Long id, Long rackId, Long requesterId, LocalDateTime bookFrom, LocalDateTime bookTo,
            LocalDateTime modifiedAt, LocalDateTime createdAt) {
        this.id = id;
        this.rackId = rackId;
        this.requesterId = requesterId;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRackId() {
        return rackId;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
