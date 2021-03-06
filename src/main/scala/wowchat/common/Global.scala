package wowchat.common

import wowchat.discord.Discord
import wowchat.game.GameCommandHandler
import io.netty.channel.nio.NioEventLoopGroup
import net.dv8tion.jda.core.entities.TextChannel

import scala.collection.mutable

object Global {

  val group = new NioEventLoopGroup
  var config: WowChatConfig = _

  var discord: Discord = _
  var game: Option[GameCommandHandler] = None

  val discordToWow = new mutable.HashMap[String, mutable.Set[(TextChannel, WowChannelConfig)]]
    with mutable.MultiMap[String, (TextChannel, WowChannelConfig)]
  val wowToDiscord = new mutable.HashMap[(Byte, Option[String]), mutable.Set[(TextChannel, DiscordChannelConfig)]]
    with mutable.MultiMap[(Byte, Option[String]), (TextChannel, DiscordChannelConfig)]
}
