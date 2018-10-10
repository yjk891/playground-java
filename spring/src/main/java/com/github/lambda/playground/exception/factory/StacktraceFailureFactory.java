package com.github.lambda.playground.exception.factory;

import com.google.common.base.Throwables;

import com.github.lambda.playground.common.Time;
import com.github.lambda.playground.exception.factory.FailureFactory;
import com.github.lambda.playground.swagger.model.Failure;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Profile({"local", "test", "integration"})
@Component
public class StacktraceFailureFactory implements FailureFactory {
  @Override
  public Failure build(Throwable e, String message, long status, String path) {
    Failure.FailureBuilder failureBuilder = Failure.builder();
    failureBuilder.timestamp(Time.getTimestamp());
    failureBuilder.code(status);
    failureBuilder.type(e.getClass().getCanonicalName());

    if (!StringUtils.isEmpty(path)) {
      failureBuilder.path(path);
    }

    if (StringUtils.isEmpty(message)) {
      failureBuilder.message(e.getMessage());
    }

    failureBuilder.stacktrace(Throwables.getStackTraceAsString(e));

    Failure failure = failureBuilder.build();
    return failure;
  }
}