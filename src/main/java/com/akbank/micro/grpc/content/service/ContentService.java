package com.akbank.micro.grpc.content.service;

import com.akbank.model.ContentServiceGrpc;
import com.akbank.model.HiRequest;
import com.akbank.model.HiResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ContentService extends ContentServiceGrpc.ContentServiceImplBase {

    @Override
    public void sayHi(HiRequest request, StreamObserver<HiResponse> responseObserver) {
        String message = request.getMessage();

        HiResponse response = HiResponse.newBuilder().setResult("Hi "+message).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
