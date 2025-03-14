package fr.skytasul.glowingentities;

import com.google.common.base.Preconditions;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

public class GlowTeam {
    public static GlowTeam DEFAULT_TEAM = new GlowTeam(ChatColor.WHITE, Team.OptionStatus.NEVER, Team.OptionStatus.NEVER);

    final ChatColor color;
    final Team.OptionStatus nameTagVisibility;
    final Team.OptionStatus collisionRule;

    public GlowTeam(ChatColor color) {
        this(color, Team.OptionStatus.NEVER, Team.OptionStatus.NEVER);
    }

    public GlowTeam(ChatColor color, Team.OptionStatus nameTagVisibility, Team.OptionStatus collisionRule) {
        this.color = Preconditions.checkNotNull(color);
        this.nameTagVisibility = Preconditions.checkNotNull(nameTagVisibility);
        this.collisionRule = Preconditions.checkNotNull(collisionRule);
    }

    public boolean isValidColor() {
        return color != null && color.isColor();
    }

    public String toId() {
        return String.valueOf(color.getChar() + nameTagVisibility.ordinal() + collisionRule.ordinal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GlowTeam that)) return false;
        return color == that.color && nameTagVisibility == that.nameTagVisibility && collisionRule == that.collisionRule;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, nameTagVisibility, collisionRule);
    }
}
