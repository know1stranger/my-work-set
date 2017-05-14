package org.ck.edu.code_design_patterns.structural.bridge;

import org.ck.edu.code_design_patterns.structural.bridge.impl.BasicProductImpl;
import org.ck.edu.code_design_patterns.structural.bridge.impl.SmartProductImpl;
import org.ck.edu.code_design_patterns.structural.bridge.intf.BasicRemoteImpl_v1;
import org.ck.edu.code_design_patterns.structural.bridge.intf.BasicRemoteImpl_v11;
import org.ck.edu.code_design_patterns.structural.bridge.intf.SmartRemote;
import org.ck.edu.code_design_patterns.structural.bridge.intf.SmartRemoteImpl_v1;

/**
 * 
 * @author uskarc01 </br>
 * 			
 * 		  <pre>
 *         For real world scenario: BridgePatternDemo (this class) is not the
 *         bridge or client(client is something/someone calling for service), it
 *         the way you structure your abstraction and implementation. Imagine
 *         Product is TV @see BasicProductImpl, Remote @see(BasicRemote)
 *         (interface for tv to work) and "you" are real customer "NOT Client or
 *         Bridge client, observer how these both fit & work allow you to extend
 *         when needed comes".

 *         Definition:Bridge design pattern can be used when both abstraction and
 *         implementation can have different hierarchies independently and we
 *         want to hide the implementation from the client application
 *         </pre>
 */
public class BridgePatternDemo {

	static private String fromClass = "from " + BridgePatternDemo.class.getSimpleName();

	public static void main(String[] args) {

		System.out.println(fromClass + ": start");

		System.out.println("Trail# 1");
		BasicProductImpl basicProductImpl = new BasicProductImpl(new BasicRemoteImpl_v1());
		/**
		 * you got the product with the interface it will work with. To consider
		 * it will work with any of the impl supporting that interface here the
		 * remote.
		 */
		// dog with its tricks
		basicProductImpl.operateChannel();

		System.out.println("Trail# 2");
		// old dog; new tricks
		basicProductImpl = new BasicProductImpl(new BasicRemoteImpl_v11());
		/**
		 * old product new tricks, as you have new remote impl here. you product
		 * knows what to do when operation is invoked.
		 */
		basicProductImpl.operateChannel();

		System.out.println("Trail# 3");
		SmartRemote tryoutSmart = new SmartRemoteImpl_v1();
		/**
		 * basic product could do smart way because it's extending greatest
		 * version available before and supports all those with this
		 * implementation and can handle extra operations. However, the
		 * extra-ops will not be used in this Product impl.
		 */
		// old dog; better tricks.
		basicProductImpl = new BasicProductImpl(tryoutSmart);

		/**
		 * you are stuck calling old operations as the product doesn't impl new
		 * smart operations @see SmartRemote. For you to be able to do either
		 * create new product version(new TV supporting new remote features) to
		 * market or change the existing product (which is not feasible in real
		 * world).</br>
		 * Now question before us is how will we call new features, this will
		 * introduce to bridge (product(impl) to the interface development).
		 */
		basicProductImpl.operateChannel();

		System.out.println("Trail# 4");

		// new dog; new tricks and also all-new-tricks
		SmartProductImpl smartProductImpl = new SmartProductImpl(new SmartRemoteImpl_v1());
		smartProductImpl.operateChannel();
		// new dog with all-new-trick
		smartProductImpl.voiceSupport();

		/**
		 * //new dog; old way..? // we will java.lang.ClassCastException
		 * smartProductImpl = new SmartProductImpl(new BasicRemoteImpl_v11());
		 * smartProductImpl.operateChannel();
		 */

		System.out.println(fromClass + ": end");
	}

}
