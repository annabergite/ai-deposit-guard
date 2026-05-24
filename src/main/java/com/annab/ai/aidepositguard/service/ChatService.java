package com.annab.ai.aidepositguard.service;

/**
 * Small abstraction for the controller to call chat models without depending
 * directly on the concrete Spring AI classes. This allows providing a
 * fallback implementation when the real Ollama auto-configuration is
 * unavailable.
 */
public interface ChatService {
    String call(String prompt);
}

