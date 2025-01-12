/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.hc.client5.http.io;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.apache.hc.core5.concurrent.Cancellable;
import org.apache.hc.core5.util.Timeout;

/**
 * Represents a request for a {@link ConnectionEndpoint} whose life cycle
 * is managed by a connection manager.
 *
 * @since 5.0
 */
public interface LeaseRequest extends Cancellable {

    /**
     * Returns {@link ConnectionEndpoint} within a given time.
     * This method will block until a connection becomes available,
     * the timeout expires, or the connection manager is shut down.
     * Timeouts are handled with millisecond precision.
     *
     * If {@link #cancel()} is called while this is blocking or
     * before this began, an {@link InterruptedException} will
     * be thrown.
     *
     * @param timeout   the operation timeout.
     *
     * @return  a connection that can be used to communicate
     *          along the given route
     *
     * @throws TimeoutException
     *         in case of a timeout
     * @throws InterruptedException
     *         if the calling thread is interrupted while waiting
     */
    //获取ConnectionEndpoint
    ConnectionEndpoint get(Timeout timeout)
            throws InterruptedException, ExecutionException, TimeoutException;

}