package org.tango.tm_monitor;


import org.tango.server.StateMachineBehavior;
import org.tango.server.attribute.AttributeConfiguration;
import org.tango.server.attribute.AttributeValue;
import org.tango.server.attribute.IAttributeBehavior;

import fr.esrf.Tango.DevFailed;

public class GenericAttribute implements IAttributeBehavior {
	private AttributeValue attributeValue = null;

	public GenericAttribute(AttributeValue attributeValue) {
		super();
		this.attributeValue = attributeValue;
	}

	private final AttributeConfiguration config = new AttributeConfiguration();

	@Override
	public AttributeConfiguration getConfiguration() throws DevFailed {
		return config;
	}

	@Override
	public StateMachineBehavior getStateMachine() throws DevFailed {
		return null;
	}

	@Override
	public AttributeValue getValue() throws DevFailed {
		return attributeValue;
	}

	@Override
	public void setValue(AttributeValue arg0) throws DevFailed {
		this.attributeValue = arg0;
	}

}
