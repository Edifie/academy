package com.ctw.workstation.booking.boundary;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long id;
    private Long rackId;
    private Long requesterId;
    private LocalDateTime bookFrom;
    private LocalDateTime bookTo;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;

    public BookingDTO() {
    }

    public BookingDTO(Long id, Long rackId, Long requesterId, LocalDateTime bookFrom, LocalDateTime bookTo,
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
