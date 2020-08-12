package catch_db;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import entity.MoblEntity;

@Local
public interface CatchSellerLocal {

	List<MoblEntity> getSellerList();

	Set<MoblEntity> getVitrinMoblKhanegi();

	Set<MoblEntity> getVitrinMoblEdari();

	Set<MoblEntity> getVitrinMoblSismoni();

	Set<MoblEntity> getVitrinMoblKabinet();

	Set<MoblEntity> getVitrinMoblMasnoat();

	Set<MoblEntity> getVitrinMoblTamirat();

	Set<MoblEntity> getVitrinMoblDecor();

	Set<MoblEntity> getVitrinMoblMotefarege();

	Set<MoblEntity> getOnlineUsers();

	List<MoblEntity> getAdiList();

}
