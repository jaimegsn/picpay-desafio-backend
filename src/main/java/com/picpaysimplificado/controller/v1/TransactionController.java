package com.picpaysimplificado.controller.v1;

import com.picpaysimplificado.domain.model.Transaction;
import com.picpaysimplificado.dto.v1.NotificationDTO;
import com.picpaysimplificado.dto.v1.TransactionDTO;
import com.picpaysimplificado.dto.v1.UserDTO;
import com.picpaysimplificado.repository.TransactionRepository;
import com.picpaysimplificado.service.v1.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/transaction")
@Tag(name = "Transaction", description = "Endpoints for performs transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @Operation(
        summary = "Performs a transaction",
        description = "Performs a transaction and saves it for future queries",
        tags = {"Transaction"},
        responses = {
            @ApiResponse(description = "Transaction Created", responseCode = "201",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = Transaction.class)
                    )
                }
            ),
            @ApiResponse (description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse (description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse (description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse (description = "Internal Error", responseCode = "500", content = @Content)
        }
    )
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.ok()
                .body(transactionService.createAndPersistTransaction(transactionDTO));
    }
}
