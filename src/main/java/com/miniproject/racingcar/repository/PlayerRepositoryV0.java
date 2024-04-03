package com.miniproject.racingcar.repository;

import com.miniproject.racingcar.connection.DBConnectionUtil;
import com.miniproject.racingcar.domain.player.Player;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.NoSuchElementException;

@Slf4j
public class PlayerRepositoryV0 {

    public Player save(Player player) throws SQLException {
        String sql = "insert into player(username, total, victory, loss, point) values(?,?,?,?,?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, player.getUsername());
            pstmt.setInt(2, player.getTotal());
            pstmt.setInt(3, player.getVictory());
            pstmt.setInt(4, player.getLoss());
            pstmt.setInt(5, player.getPoint());
            return player;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public Player findByName(String userName) throws SQLException {
        String sql = "select * fro player where username=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userName);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                Player player = new Player();
                player.setUsername(rs.getString("username"));
                player.setTotal(rs.getInt("total"));
                player.setVictory(rs.getInt("victory"));
                player.setLoss(rs.getInt("loss"));
                player.setPoint(rs.getInt("point"));
                return player;
            } else {
                throw new NoSuchElementException("player not found playerName=" + userName);
            }
        } catch (SQLException e) {
            log.info("db error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }
    }

    public void update(String username, int total, int victory, int loss, int point) throws SQLException {
        String sql = "update player set total=?,victory=?,loss=?,point=? where username=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, total);
            pstmt.setInt(2, victory);
            pstmt.setInt(3, loss);
            pstmt.setInt(4, point);
            pstmt.setString(5, username);
        } catch (SQLException e) {
            log.info("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public void delete(String playerName) throws SQLException {
        String sql = "delete from player where username=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, playerName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.info("db error", e);
            throw e;
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if (stmt != null) {
            try {
                stmt.close(); //SQL Exception
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
