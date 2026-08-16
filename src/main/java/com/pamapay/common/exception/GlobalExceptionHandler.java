package com.pamapay.common.exception;
import com.pamapay.auth.exception.UserNotFoundException;
import com.pamapay.auth.exception.WalletNotFoundException;
import com.pamapay.wallet.exception.InvalidDepositAmountException;
import com.pamapay.wallet.exception.WalletNotActiveException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.Map;
import java.time.Instant;
import jakarta.persistence.OptimisticLockException;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleEmailAlreadyExistsException(
            EmailAlreadyExistsException exception,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {

        Map<String, String> fieldErrors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        fieldErrors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        ValidationErrorResponse response =
                new ValidationErrorResponse(
                        Instant.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        "Validation failed",
                        request.getRequestURI(),
                        fieldErrors
                );

        return ResponseEntity
                .badRequest()
                .body(response);
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCredentialsException(
            InvalidCredentialsException exception,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFoundException(
            UserNotFoundException exception,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(WalletAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleWalletAlreadyExistsException(
            WalletAlreadyExistsException exception,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
        @ExceptionHandler(WalletNotFoundException.class)
        public ResponseEntity<ApiErrorResponse> handleWalletNotFOundException(HttpServletRequest request,WalletNotFoundException exception){
            ApiErrorResponse apiErrorResponse=new ApiErrorResponse(
                    Instant.now(),
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    exception.getMessage(),
                    request.getRequestURI()
            );
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorResponse);
        }
        @ExceptionHandler(InvalidDepositAmountException.class)
       public ResponseEntity<ApiErrorResponse> handleInvalidDepositAmount(InvalidDepositAmountException exception,HttpServletRequest request){
           HttpStatus status= HttpStatus.BAD_REQUEST;
           ApiErrorResponse response=new ApiErrorResponse(
                   Instant.now(),
                   status.value(),
                   status.getReasonPhrase(),
                   exception.getMessage(),
                   request.getRequestURI()
           );
            return ResponseEntity.status(status).body(response);
        }
        @ExceptionHandler(WalletNotActiveException.class)
      public ResponseEntity<ApiErrorResponse> handleWalletNotActive(WalletNotActiveException exception,HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        ApiErrorResponse response=new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
            return ResponseEntity
                    .status(status)
                    .body(response);
        }
        @ExceptionHandler(OptimisticLockException.class)
        public ResponseEntity<ApiErrorResponse> handlingOptimisticLock(OptimisticLockException exception,HttpServletRequest request){
          HttpStatus status = HttpStatus.CONFLICT;
            ApiErrorResponse response=new ApiErrorResponse(
                    Instant.now(),
                    status.value(),
                    status.getReasonPhrase(),
                    "Wallet was modified by another request. Please try again.",
                    request.getRequestURI()
            );
            return ResponseEntity
                    .status(status)
                    .body(response);
        }
    @ExceptionHandler(ObjectOptimisticLockingFailureException.class)
    public ResponseEntity<ApiErrorResponse> handleOptimisticLockingFailure(
            ObjectOptimisticLockingFailureException exception,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                "Wallet was modified by another request. Please try again.",
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(response);
    }
    }
