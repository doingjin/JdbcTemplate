package model.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ClientService")
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientDAO cdao;
	
	public void insertC(ClientVO cvo) {
		cdao.insertC(cvo);
	}

	public void updateC(ClientVO cvo) {
		cdao.updateC(cvo);
	}

	public void deleteC(ClientVO cvo) {
		cdao.deleteC(cvo);
	}

	public ClientVO login(ClientVO cvo) {
		
		try{
			return cdao.login(cvo);
		} catch(Exception e) {
			return null;
		}
		
	}

	public List<ClientVO> getCList() {
		return cdao.getCList();
	}

}
