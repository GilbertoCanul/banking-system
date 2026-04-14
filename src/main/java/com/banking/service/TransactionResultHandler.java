package com.banking.service;

import com.banking.domain.*;

public class TransactionResultHandler {
    public String handleTransactionResult(TransactionResult result) {
        return switch (result) {
            case TransactionSuccess s when s.amount() > 100_000L ->
                    "Transferencia de alto valor completada. ID: " + s.transactionId() + ". Monto: " + s.amount();
            case TransactionSuccess s ->
                    "Transferencia completada. ID: " + s.transactionId() + ". Monto: " + s.amount();
            case InvalidTransactionFailure f ->
                    "Transferencia no válida: " + f.reason();
            case InsufficientFundsFailure f ->
                    "Fondos insuficientes. Disponible: " + f.availableAmount() +
                            ", solicitado: " + f.requestedAmount();
            case ReceiverNotFoundFailure f ->
                    "Cuenta destino no encontrada: " + f.receiverAccountId();
            case ConnectionFailure f ->
                    "Error de conexión en " + f.serviceName();
        };
    }
}