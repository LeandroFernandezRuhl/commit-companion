package com.leandroruhl.commitcompanion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The DiscordBotInstance class represents a bot instance in a specific Discord server.
 * This class holds information about that specific server like the channel where it
 * should send messages and the GitHub repositories it should watch.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscordBotInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serverId;
    private String channelId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RepoInfo> repositories; // List of GitHub repositories to watch

    public DiscordBotInstance(String serverId, String channelId) {
        this.serverId = serverId;
        this.channelId = channelId;
        this.repositories = new ArrayList<>();
    }
}
