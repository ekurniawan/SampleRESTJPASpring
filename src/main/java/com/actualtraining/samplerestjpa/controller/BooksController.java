package com.actualtraining.samplerestjpa.controller;

import com.actualtraining.samplerestjpa.entity.Book;
import com.actualtraining.samplerestjpa.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Mengambil semua data buku",
            description = "Mengambil semua data buku")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Semua buku ditemukan",
            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404",description = "buku tidak ditemukan",content = @Content)})
    @GetMapping
    public ResponseEntity findAllBooks() {
        return ResponseEntity.ok(bookService.findAllWithCategory());
    }

}
