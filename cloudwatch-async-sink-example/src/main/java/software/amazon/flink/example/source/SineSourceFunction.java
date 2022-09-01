/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package software.amazon.flink.example.source;

import java.time.Instant;

public class SineSourceFunction extends DataGenSourceFunction {

    private static final long PERIOD = 60 * 60 * 1000;
    private static final long SCALE = 50;
    private static final double TWO_PI = Math.PI * 2;

    public SineSourceFunction(final String category) {
        super(category);
    }

    @Override
    long getValue(Instant timestamp) {
        double radians = TWO_PI / PERIOD * (timestamp.toEpochMilli() % PERIOD);
        double y = Math.sin(radians) * SCALE + SCALE;
        return (long) y;
    }

}